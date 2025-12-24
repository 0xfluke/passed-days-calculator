package com.example.demo;
public class DateCalculator {
    // Fields
    private int startDates, startMonths, startYears, endDates, endMonths, endYears;
    private long startDateMS, endDateMS, passedDays;
    int daysInMonths[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private long finalTotalTime;

    // Calculation Method
    public boolean isLeapYear(int years){
        if (years % 4 == 0){
            if(years % 100 == 0 && years % 400 == 0){
                return true;
            }
            else if(years % 100 == 0 && years % 400 != 0){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    public int dayInFullYearCounter(int years){
        int totalDays = 0;
        for (int i = 1970; i < years; i++){
            if(isLeapYear(i)){
                totalDays += 366;
            }
            else{
                totalDays += 365;
            }
        }
        return totalDays;
    }
    public int dayInTargetYearCounter(int months, int years, int days){
        int totalDays = 0;
        for(int i = 1; i < months; i++){
            if(i == 2 && isLeapYear(years)){
                totalDays += 29;
            }
            else{
                totalDays += daysInMonths[i];
            }
        }
        totalDays += (days - 1);
        return totalDays;
    }
    public long finalTotalTime(){
        long finalTotalTime = ((dayInFullYearCounter(endYears) + dayInTargetYearCounter(endMonths, endYears, endDates)) - (dayInFullYearCounter(startYears) + dayInTargetYearCounter(startMonths, startYears, startDates))); ;
        return Math.toIntExact(finalTotalTime);
    }

    // Constructor
    DateCalculator(int startDates, int startMonths, int startYears, int endDates, int endMonths, int endYears){
        this.startDates = startDates;
        this.startMonths = startMonths;
        this.startYears = startYears;
        this.endDates = endDates;
        this.endMonths = endMonths;
        this.endYears = endYears;
    }

}