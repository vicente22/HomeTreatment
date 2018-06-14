package cl.vicentepc.miappprueba2.models;

import com.orm.SugarRecord;

public class User extends SugarRecord{

    private String name;
    private int age;
    private String aboutMyAnnoyance, homeTreatment;

    public User() {
    }

    public User(String name, int age, String aboutMyAnnoyance, String homeTreatment) {
        this.name = name;
        this.age = age;
        this.aboutMyAnnoyance = aboutMyAnnoyance;
        this.homeTreatment = homeTreatment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAboutMyAnnoyance() {
        return aboutMyAnnoyance;
    }

    public void setAboutMyAnnoyance(String aboutMyAnnoyance) {
        this.aboutMyAnnoyance = aboutMyAnnoyance;
    }

    public String getHomeTreatment() {
        return homeTreatment;
    }

    public void setHomeTreatment(String homeTreatment) {
        this.homeTreatment = homeTreatment;
    }
}
