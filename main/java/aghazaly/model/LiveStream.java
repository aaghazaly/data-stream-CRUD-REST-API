package aghazaly.model;

import java.time.LocalDateTime;

public record LiveStream(String id , String title , String description , String url , LocalDateTime startDate , LocalDateTime endDate) {


    public void set(int i, LiveStream stream) {
    }
}