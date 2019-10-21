package org.kanishka.onclinicwebbackend.repository;

import org.kanishka.onclinicwebbackend.model.reports.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends MongoRepository<Report,String> {
    List<Report> findReportsByUserIdAndType(String userId, String type);

    Report findReportBy_id(String id);

}
