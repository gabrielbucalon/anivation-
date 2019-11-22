package model;

/**
 *
 * @author Gabriel Bucalon
 */
public class AniSeries {
    
    private String idAniSeries;
    private String seriesName;
    private String seriesNote;
    private String nicknameUser;
    
    public AniSeries(){}

    public AniSeries(String idAniSeries, String seriesName, String seriesNote, String nicknameUser) {
        this.idAniSeries = idAniSeries;
        this.seriesName = seriesName;
        this.seriesNote = seriesNote;
        this.nicknameUser = nicknameUser;
    }    
    
    public AniSeries(int i, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the idAniSeries
     */
    public String getIdAniSeries() {
        return idAniSeries;
    }

    /**
     * @param idAniSeries the idAniSeries to set
     */
    public void setIdAniSeries(String idAniSeries) {
        this.idAniSeries = idAniSeries;
    }

    /**
     * @return the seriesName
     */
    public String getSeriesName() {
        return seriesName;
    }

    /**
     * @param seriesName the seriesName to set
     */
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    /**
     * @return the seriesNote
     */
    public String getSeriesNote() {
        return seriesNote;
    }

    /**
     * @param seriesNote the seriesNote to set
     */
    public void setSeriesNote(String seriesNote) {
        this.seriesNote = seriesNote;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nicknameUser;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nicknameUser = nickName;
    }
}
