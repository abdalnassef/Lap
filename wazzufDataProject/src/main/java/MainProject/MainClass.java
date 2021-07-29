package MainProject;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class MainClass {
    public static void main(String[] args) throws IOException {
        // 1- Reading the data
        Table wuzzuf = Table.read().csv("src/main/resources/Data/Wuzzuf_Jobs.csv");
        System.out.println(wuzzuf.first(50));

        // 2- Display Structure and summary of the data
        System.out.println(wuzzuf.structure().toString());
        System.out.println(wuzzuf.summary().toString());

        // 3- Clean the Data(Null, duplication)
        System.out.println(HasNullOrEmpty(wuzzuf)?"Has empty":"There is no empty or null values");

        // 1.1 Converting the data into list of objects
        List<JobObserv> jobs = JobObserv.jobsToList(wuzzuf);

        // 4- count the jobs for each company and display that in order
        // (What are the most demanding companies for jobs)  ******************** >> mybe top 10 is better
        Map<String, Integer> mapCompanyFreq = getCompanyAndNumberOfJobs(jobs);

        // 5- Shw step 4 in pie Chart
        new SwingWrapper<>(getPieChart(mapCompanyFreq)).displayChart();

        // 6- Find out what are IT the most popular job titles  >>>>>>>>>  i took 2 or less out of the values for the bar chart to be more clear
        Map<String, Integer> mapTitleFreq = getTitleAndNumberOfJobs(jobs);

        // 7- show step 6 in bar chart
        new SwingWrapper<>(getBarChart(mapTitleFreq)).displayChart();

        // 8- find out the most popular areas
        Map<String, Integer> mapLocationFreq = getLocationsNumOfLocs(jobs,30);

        // 9- show step 8 in bar chart
        new SwingWrapper<>(getBarChart(mapLocationFreq)).displayChart();

        // 10-	Print skills one by one and how many each repeated and order the output to find out the most important skills required?
        String maxSkillCount = getSkillCount(jobs);
        System.out.println(maxSkillCount);

        // 11-	Factorize the YearsExp feature and convert it to numbers in new col. (Bounce )
        wuzzuf.addColumns(getExpNumCol(jobs));
        System.out.println(wuzzuf.first(10));

        // 12-	Apply K-means for job title and companies (Bounce )

    }

    private static IntColumn getExpNumCol(List<JobObserv> jobs) {

        List<String> expList = jobs.stream().map(x -> x.getYearsExp()).collect(Collectors.toList()) ;
        List<String> expSet = expList.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
        List<Integer> expNumList = new ArrayList<>();
        for (String expLevel:expList) {
            for (String s:expSet) {
                if(expLevel.equals(s))
                    expNumList.add(expSet.indexOf(s));
            }
        }
        return IntColumn.create("YearsExp In Numbers",expNumList.stream().mapToInt(x -> x+1));
    }

    private static String getSkillCount(List<JobObserv> jobs) {
        //listing all the skills
        List<String> lstAllSkills = new ArrayList<>() ;
        for (JobObserv job:jobs) {
            for (String skill:job.getSkills().split(",")) {
                lstAllSkills.add(skill);
            }
        }

        // counting frequency
        Map<String,Integer> temp =new HashMap<>() ;
        for (String s:lstAllSkills.stream().collect(Collectors.toSet())) {
            temp.put(s,Collections.frequency(lstAllSkills,s));
        }


        /////////// find the highest freq skill
        int max = 0 ;
        String nameMax = "";
        for (Map.Entry<String,Integer> entry:temp.entrySet()) {
            if (entry.getValue() > max ){
                max = entry.getValue();
                nameMax = entry.getKey();
            }
        }

        return  nameMax +" Is the Most Required Sill Will "+ max  +" Number of occurencies ";
    }

    private static Map<String, Integer> getLocationsNumOfLocs(List<JobObserv> jobs,int howManyFromTop) {

        Map<String, List<JobObserv>> mapLocationJobs = jobs.stream().collect(Collectors.groupingBy(JobObserv::getLocation));
        Map<String, Integer> mapLocationFreq = mapLocationJobs.keySet().stream()
                .collect(Collectors.toMap(Function.identity(), v -> 0));
        for (Map.Entry<String,List<JobObserv>> entry:mapLocationJobs.entrySet()) {
            mapLocationFreq.put(entry.getKey(),mapLocationJobs.get(entry.getKey()).size());
        }
        Map<String, Integer> newMap = sortByValue(mapLocationFreq);

        Map<String, Integer> mapLocationFreq1 = new HashMap<>();

        for (int i = newMap.keySet().size() -howManyFromTop; i < newMap.keySet().size(); i++) {
            System.out.println(newMap.keySet().stream().collect(Collectors.toList()).get(i));
            mapLocationFreq1.put(newMap.keySet().stream().collect(Collectors.toList()).get(i),newMap.get(newMap.keySet().stream().collect(Collectors.toList()).get(i)));
        }

        return  mapLocationFreq1 ;
    }

    private static Map<String, Integer> getTitleAndNumberOfJobs(List<JobObserv> jobs) {

        Map<String, List<JobObserv>> mapTitleJobs = jobs.stream()
                .filter(job -> job.getSkills().contains("Information Technology (IT)"))
                .collect(Collectors.groupingBy(JobObserv::getTitle));

        Map<String, Integer> mapTitleFreq = mapTitleJobs.keySet().stream()
                .collect(Collectors.toMap(Function.identity(), v -> 0));
        for (Map.Entry<String,List<JobObserv>> entry:mapTitleJobs.entrySet()) {
            mapTitleFreq.put(entry.getKey(),mapTitleJobs.get(entry.getKey()).size());
        }
        Map<String, Integer> newMap = new HashMap<>();
        for (Map.Entry<String,Integer> entry:sortByValue(mapTitleFreq).entrySet()) {
            if (entry.getValue() > 1)
                newMap.put(entry.getKey(), entry.getValue());
        }

        return newMap;
    }

    private static Map<String, Integer> getCompanyAndNumberOfJobs(List<JobObserv> jobs) {

        Map<String, List<JobObserv>> mapCompanyList = jobs.stream().collect(Collectors.groupingBy(x -> x.getCompany()));

        Map<String, Integer> mapCompanyFreq = mapCompanyList.keySet().stream()
                .collect(Collectors.toMap(Function.identity(), v -> 0));
        for (Map.Entry<String,List<JobObserv>> entry:mapCompanyList.entrySet()) {
            mapCompanyFreq.put(entry.getKey(),mapCompanyList.get(entry.getKey()).size());
        }
        Map<String, Integer> newMap = sortByValue(mapCompanyFreq);
        return newMap;
    }

    public static boolean HasNullOrEmpty(Table data) {
        for (Row row: data) {
            // if any value is null or empty
            for (Column column:data.columns()) {
                if (row.isMissing(column.name()))
                    return true;
            }
        }
        return false;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static PieChart getPieChart(Map<String,Integer> values) {
        // Create Chart
        PieChart chart = new PieChartBuilder().width(1000).height(600).title("Pie Chart").build();
        // Customize Chart
        chart.getStyler().setCircular(false);
        // Series
        for (Map.Entry<String,Integer> entry:values.entrySet())
            chart.addSeries(entry.getKey(), entry.getValue());

        return chart;
    }

    public  static CategoryChart getBarChart(Map<String, Integer> values) {
        // Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(1200).height(900).title("Histogram").xAxisTitle("Jobs").yAxisTitle("Number").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setXAxisLabelRotation(-90);

        // Series
        chart.addSeries("Job Frequencies", values.keySet().stream().collect(Collectors.toList()), values.values().stream().collect(Collectors.toList()));
        return chart;
    }

}
