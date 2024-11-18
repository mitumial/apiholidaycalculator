package apiholiday.apiholidaycalculator.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="festivo")
public class Holiday {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="nombre", length=100, nullable=false)
    private String name;

    @Column(name="dia", nullable=false)
    private int day;

    @Column(name="mes", nullable=false)
    private int month;

    @Column(name="diaspascua", nullable=false)
    private int easterDays;

    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id", nullable = false)
    private TypeOfHoliday typeOfHoliday;

    public Holiday() {
    }

    public Holiday(int id, String name, int day, int month, int easterDays, TypeOfHoliday typeOfHoliday) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
        this.easterDays = easterDays;
        this.typeOfHoliday = typeOfHoliday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getEasterDays() {
        return easterDays;
    }

    public void setEasterDays(int easterDays) {
        this.easterDays = easterDays;
    }

    public TypeOfHoliday getTypeOfHoliday() {
        return typeOfHoliday;
    }

    public void setTypeOfHoliday(TypeOfHoliday typeOfHoliday) {
        this.typeOfHoliday = typeOfHoliday;
    }
    
}
