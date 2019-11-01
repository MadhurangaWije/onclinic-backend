package org.kanishka.onclinicwebbackend.controller;

import org.kanishka.onclinicwebbackend.model.reports.Report;
import org.kanishka.onclinicwebbackend.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@CrossOrigin(origins = "https://4409a0f0.ngrok.io")
public class ReportsController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("{_id}")
    public Report getReport(@PathVariable String _id){
        return this.reportRepository.findReportBy_id(_id);

    }

    @GetMapping
    public List<Report> getReports(@RequestParam("user") String email, @RequestParam("type") String type){
        return this.reportRepository.findReportsByUserIdAndType(email,type);
    }

    @PostMapping
    public Report saveReport(@RequestBody Report report){
        return reportRepository.save(report);
    }

    @DeleteMapping("{id}")
    public void deleteReport(@PathVariable String id){
        Report reportBy_id = this.reportRepository.findReportBy_id(id);
        this.reportRepository.delete(reportBy_id);
    }

}