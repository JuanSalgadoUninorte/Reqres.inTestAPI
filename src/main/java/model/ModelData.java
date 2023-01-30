package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModelData {

    private String name;
    private String jobOne;
    private String jobTwo;
    private String job;
    private String numUno;
    private String numDos;
    private int notFoundStatus;
    private int okStatus;
    private int responseStatus;
    private String emailSuccessful;
    private String passwordOne;
    private String passwordTwo;
    private String emailUnsuccessfulOne;
    private String emailUnsuccessfulTwo;

    public String getNumDos() {
        return numDos;
    }

    public void setNumDos(String numDos) {
        this.numDos = numDos;
    }

    public String getJobOne() {
        return jobOne;
    }

    public void setJobOne(String jobOne) {
        this.jobOne = jobOne;
    }

    public String getJobTwo() {
        return jobTwo;
    }

    public void setJobTwo(String jobTwo) {
        this.jobTwo = jobTwo;
    }

    public String getEmailSuccessful() {
        return emailSuccessful;
    }

    public void setEmailSuccessful(String emailSuccessful) {
        this.emailSuccessful = emailSuccessful;
    }

    public String getPasswordOne() {
        return passwordOne;
    }

    public void setPasswordOne(String passwordOne) {
        this.passwordOne = passwordOne;
    }

    public String getPasswordTwo() {
        return passwordTwo;
    }

    public void setPasswordTwo(String passwordTwo) {
        this.passwordTwo = passwordTwo;
    }

    public String getEmailUnsuccessfulOne() {
        return emailUnsuccessfulOne;
    }

    public void setEmailUnsuccessfulOne(String emailUnsuccessfulOne) {
        this.emailUnsuccessfulOne = emailUnsuccessfulOne;
    }

    public String getEmailUnsuccessfulTwo() {
        return emailUnsuccessfulTwo;
    }

    public void setEmailUnsuccessfulTwo(String emailUnsuccessfulTwo) {
        this.emailUnsuccessfulTwo = emailUnsuccessfulTwo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

    public int getOkStatus() {
        return okStatus;
    }

    public void setOkStatus(int okStatus) {
        this.okStatus = okStatus;
    }

    public int getNotFoundStatus() {
        return notFoundStatus;
    }

    public void setNotFoundStatus(int notFoundStatus) {
        this.notFoundStatus = notFoundStatus;
    }

    public String getNumUno() {
        return numUno;
    }

    public void setNumUno(String numUno) {
        this.numUno = numUno;
    }

    public static List<ModelData> setData(DataTable dataTable) {
        List<ModelData> data = new ArrayList<>();
        List<Map<String, String>> mapIfo = dataTable.asMaps();
        for (Map<String, String> map : mapIfo) {
            data.add(new ObjectMapper().convertValue(map, ModelData.class));
        }
        return data;
    }

}
