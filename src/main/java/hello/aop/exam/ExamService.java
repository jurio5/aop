package hello.aop.exam;

import hello.aop.exam.annotation.TimeTraceLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

//    @Trace
    @TimeTraceLog
    public void request(String itemId) throws InterruptedException {
        examRepository.save(itemId);
        Thread.sleep(1500);
    }
}
