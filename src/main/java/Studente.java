import jakarta.persistence.*;

import java.time.LocalDate;

@Entity  // serve al jpa per capire che la classe deve avere una corrispondenza nel database
@Table(name = "studenti") // per dare un nome diverso alla tabella nel database rispetto al nome della classe

public class Studente {

    //@Id serve per rendere il campo primary key nella tabella corrispondente
    @Id

    private int matricola;

    //@Column puo essere usato per cambia il nome del campo nella tabella, per settare il notnull,
    // per rendere il campo unique, per settare la lunghezza del campo, per
    @Column(length  = 20,nullable = false)
    private String nome;

    @Column(length =  20,nullable = false)
    private String cognome;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_studente" )
    private TipoStudente tipoStudente;

    public Studente(int matricola, String nome, String cognome, LocalDate dataNascita, TipoStudente tipoStudente) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.tipoStudente = tipoStudente;
    }

    public int getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public TipoStudente getTipoStudente() {
        return tipoStudente;
    }



    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setTipoStudente(TipoStudente tipoStudente) {
        this.tipoStudente = tipoStudente;
    }
}
