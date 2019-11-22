package model;

/**
 *
 * @author Gabriel Bucalon
 */
public class AnimeReSeries {
    private String comments;
    private String nameAimeSeries;
    private String gender;
    private String episodes;
    private String sinopse;
    private String note;
    private String nicknameUser;
    private String idUser;

    public AnimeReSeries(String comments, String nameAimeSeires, String gender,
            String episodes, String sinopse, String note) {
        this.comments = comments;
        this.nameAimeSeries = nameAimeSeires;
        this.gender = gender;
        this.episodes = episodes;
        this.sinopse = sinopse;
        this.note = note;
    }
    
    public AnimeReSeries(){}
    
    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the nameAimeSeries
     */
    public String getNameAimeSeries() {
        return nameAimeSeries;
    }

    /**
     * @param nameAimeSeries the nameAimeSeries to set
     */
    public void setNameAimeSeries(String nameAimeSeries) {
        this.nameAimeSeries = nameAimeSeries;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the episodes
     */
    public String getEpisodes() {
        return episodes;
    }

    /**
     * @param episodes the episodes to set
     */
    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    /**
     * @return the sinopse
     */
    public String getSinopse() {
        return sinopse;
    }

    /**
     * @param sinopse the sinopse to set
     */
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the nicknameUser
     */
    public String getNicknameUser() {
        return nicknameUser;
    }

    /**
     * @param nicknameUser the nicknameUser to set
     */
    public void setNicknameUser(String nicknameUser) {
        this.nicknameUser = nicknameUser;
    }

    /**
     * @return the idUser
     */
    public String getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

}
