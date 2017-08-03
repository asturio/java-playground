package bogus.karameikos.todo.model;

import java.util.Date;

public class Todo {
    private int id;
    private String name;
    private String beschreibung;
    private String url;
    private Date datum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public Date getDatum()
	{
		return datum;
	}

	public void setDatum(Date datum)
	{
		this.datum = datum;
	}
}
