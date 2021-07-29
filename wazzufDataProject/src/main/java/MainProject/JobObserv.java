package MainProject;

import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

import java.util.ArrayList;
import java.util.List;

public class JobObserv {
    String Title;
    String Company;
    String Location;
    String Type;
    String Level;
    String YearsExp;
    String Country;
    String Skills;

    public JobObserv(String title, String company, String location, String type, String level, String yearsExp, String country, String skills) {
        Title = title;
        Company = company;
        Location = location;
        Type = type;
        Level = level;
        YearsExp = yearsExp;
        Country = country;
        Skills = skills;
    }

    public JobObserv() {
    }

    public  static List<JobObserv> jobsToList(Table data)
    {
        JobObserv tempJ;
        List<JobObserv> lstTemp = new ArrayList<>();
        for (Row row: data) {
            lstTemp.add(
            tempJ = new JobObserv(row.getString(0),
                    row.getString(1),
                    row.getString(2),
                    row.getString(3),
                    row.getString(4),
                    row.getString(5),
                    row.getString(6),
                    row.getString(7)));
        }

        return  lstTemp ;
    }

    @Override
    public String toString() {
        return "JobObserv{" +
                "Title='" + Title + '\'' +
                ", Company='" + Company + '\'' +
                ", Location='" + Location + '\'' +
                ", Type='" + Type + '\'' +
                ", Level='" + Level + '\'' +
                ", YearsExp='" + YearsExp + '\'' +
                ", Country='" + Country + '\'' +
                ", Skills='" + Skills + '\'' +
                '}';
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public String getYearsExp() {
        return YearsExp;
    }

    public void setYearsExp(String yearsExp) {
        YearsExp = yearsExp;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String skills) {
        Skills = skills;
    }
}
