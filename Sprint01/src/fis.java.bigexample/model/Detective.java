package fis.java.bigexample.model;

import fis.java.bigexample.model.enums.EmploymentStatus;
import fis.java.bigexample.model.enums.Rank;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Detective extends AbstractEntity {
    private  String userName;

    private String firstName;

    private String lastName;

    private String password;

    private LocalDateTime hiringDate;

    private  Person person;

    private String badgeNumber;

    private Rank rank;

    private  Boolean armed;

    private EmploymentStatus status;

    private Set<CriminalCase> criminalCases;

    private Set<TrackEntry> trackEntries;

    public Detective() {

    }

    public Detective(String userName,
                     String firstName,
                     String lastName,
                     String password,
                     LocalDateTime hiringDate,
                     Person person,
                     String badgeNumber,
                     Rank rank,
                     Boolean armed,
                     EmploymentStatus status,
                     Set<CriminalCase> criminalCases,
                     Set<TrackEntry> trackEntries) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.hiringDate = hiringDate;
        this.person = person;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.armed = armed;
        this.status = status;
        this.criminalCases = criminalCases;
        this.trackEntries = trackEntries;
    }

    public Detective(Long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt,
                     String userName,
                     String firstName,
                     String lastName,
                     String password,
                     LocalDateTime hiringDate,
                     Person person,
                     String badgeNumber,
                     Rank rank,
                     Boolean armed,
                     EmploymentStatus status,
                     Set<CriminalCase> criminalCases,
                     Set<TrackEntry> trackEntries) {
        super(id, version, createdAt, modifiedAt);
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.hiringDate = hiringDate;
        this.person = person;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
        this.armed = armed;
        this.status = status;
        this.criminalCases = criminalCases;
        this.trackEntries = trackEntries;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDateTime hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Boolean getArmed() {
        return armed;
    }

    public void setArmed(Boolean armed) {
        this.armed = armed;
    }

    public EmploymentStatus getStatus() {
        return status;
    }

    public void setStatus(EmploymentStatus status) {
        this.status = status;
    }

    public Set<CriminalCase> getCriminalCases() {
        return criminalCases;
    }

    public void setCriminalCases(Set<CriminalCase> criminalCases) {
        this.criminalCases = criminalCases;
    }

    public Set<TrackEntry> getTrackEntries() {
        return trackEntries;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }
}
