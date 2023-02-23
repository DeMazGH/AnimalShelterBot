package pro.sky.animalshelterbot.model;


import java.time.LocalDateTime;
import java.util.Objects;


public class Connection {
    private Long petId;
    private Long chatId;
    //ид усыновителя
    private LocalDateTime dateTime;
    //дата усыновления
    public Connection() {

    }


    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Connection)) return false;
        Connection that = (Connection) o;
        return Objects.equals(getPetId(), that.getPetId()) && Objects.equals(getChatId(), that.getChatId()) && Objects.equals(getDateTime(), that.getDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPetId(), getChatId(), getDateTime());
    }
}
