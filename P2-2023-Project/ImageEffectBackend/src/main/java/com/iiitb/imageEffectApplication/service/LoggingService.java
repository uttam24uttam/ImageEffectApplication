package com.iiitb.imageEffectApplication.service;
import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoggingService {

    private List<LogModel> LogModelList = new ArrayList<>();
 
    public void addLog(String fileName, String effectName, String optionValues) {
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String time=dtf.format(now);
        LogModel tempLogModel=new LogModel(time, fileName, effectName, optionValues);
        this.LogModelList.add(tempLogModel);
    }
 
    public List<LogModel> getAllLogs() {
        return LogModelList;
    }

    public List<LogModel> getLogsByEffect(String effectName) {
        return LogModelList.stream()
                .filter(log->log.getEffectName().equals(effectName))
                .collect(Collectors.toList());
    }

    public void clearLogs() {
        this.LogModelList.clear();
    }

    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String time1 = dtf.format(startTime);
        String time2 = dtf.format(endTime);
        return LogModelList.stream()
                .filter(log->(log.getTimestamp().compareTo(time1)>=0 && log.getTimestamp().compareTo(time2)<=0))
                .collect(Collectors.toList());
    }
}
