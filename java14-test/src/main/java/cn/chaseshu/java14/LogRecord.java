package cn.chaseshu.java14;

import java.time.LocalDate;
import java.util.Objects;

// 旧版
public final class LogRecord {

    private final int id;
    private final LocalDate date;
    private final String detail;

    public LogRecord(int id, LocalDate date, String detail) {
        this.id = id;
        this.date = date;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "LogRecord{" +
                "id=" + id +
                ", date=" + date +
                ", detail='" + detail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogRecord logRecord = (LogRecord) o;
        return id == logRecord.id &&
                Objects.equals(date, logRecord.date) &&
                Objects.equals(detail, logRecord.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, detail);
    }
}
