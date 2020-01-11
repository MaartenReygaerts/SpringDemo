package be.intecbrussel.eddy.springeddy.exeptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoGuyWasFound {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String error;
    private int status;
    private LocalDateTime timeStamp;

    public String getError() {
        return error;
    }

    public NoGuyWasFound setError(String error) {
        this.error = error;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public NoGuyWasFound setStatus(int status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public NoGuyWasFound setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }
}
