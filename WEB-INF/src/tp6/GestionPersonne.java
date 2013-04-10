package tp6;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class GestionPersonne {

    private Personne    personne;
    private Film        film;
    private Serie       serie;
    private RoleFilm    roleFilm;
    private RoleEpisode roleEpisode;
    private Connexion   cx;

    public GestionPersonne(Personne personne, Film film, RoleFilm roleFilm, Serie serie,
                           RoleEpisode roleEpisode) throws Tp6Exception {
        this.cx = personne.getConnexion();
        if (cx != film.getConnexion() || cx != serie.getConnexion()
                || cx != roleFilm.getConnexion() || cx != roleEpisode.getConnexion()) {
            throw new Tp6Exception(
                    "Les instances de connexions dans GestionPersonne sont différentes");
        }
        this.personne = personne;
        this.film = film;
        this.serie = serie;
        this.roleFilm = roleFilm;
        this.roleEpisode = roleEpisode;
    }

    public void ajoutPersonne(String nom, Date dateNaissance, String lieuNaissance,
            int sexe) throws Exception {
        try {
            // Vérifie si la personne existe déjà 
            if (personne.existe(nom)) {
                throw new Tp6Exception("Impossible d'ajouter la personne " + nom
                        + " : la personne existe deja.");
            }

            // Verifie si le sexe est valide
            if (sexe < 0 || sexe > 1) {
                throw new Tp6Exception("Impossible d'ajouter la personne " + nom
                        + " : le sexe est invalide.");
            }

            personne.ajouter(nom, dateNaissance, lieuNaissance, sexe);
            cx.commit();
        } catch (Exception e) {
            cx.rollback();
            throw e;
        }
    }

    public void supprimerPersonne(String nom) throws Exception {
        try {
            // Si la personne n'existe pas
            if (!personne.existe(nom)) {
                throw new Tp6Exception("Impossible de supprimer, la personne " + nom
                        + " n'existe pas.");
            }
            // S'il est le realisateur d'au moins un film
            if (!film.filmDeRealisateur(nom).isEmpty()) {
                throw new Tp6Exception("Impossible de supprimer, la personne " + nom
                        + " a realise au moins un film.");
            }
            // S'il est le realisateur d'au moins une serie
            if (!serie.serieDeRealisateur(nom).isEmpty()) {
                throw new Tp6Exception("Impossible de supprimer, la personne " + nom
                        + " a realise au moins une serie.");
            }
            // S'il a un role dans au moins un film
            if (!roleFilm.rolesDeActeur(nom).isEmpty()) {
                throw new Tp6Exception("Impossible de supprimer, la personne " + nom
                        + " a un role dans au moins un film.");
            }
            // S'il a au moins un role dans au moins un episode d'au moins une serie
            if (!roleEpisode.rolesDeActeur(nom).isEmpty()) {
                throw new Tp6Exception("Impossible de supprimer, la personne " + nom
                        + " a un role dans au moins une serie.");
            }

            int nb = personne.enlever(nom);
            cx.commit();
            System.out.println(nb + " personne supprime.");
        } catch (Exception e) {
            cx.rollback();
            throw e;
        }
    }

    public List<TuplePersonne> afficherRealisateur() throws SQLException {
        return personne.realisateurDeFilms();
    }

    public List<TupleRoleFilm> afficherFilmDeActeur(String nom) throws Tp6Exception,
            SQLException {
        if (!personne.existe(nom)) {
            throw new Tp6Exception("Impossible d'afficher, l'acteur " + nom
                    + " n'existe pas.");
        }
        return roleFilm.rolesDeActeur(nom);
    }

    public List<TupleSerie> afficherSerieAvecActeur(String nom) throws Tp6Exception,
            SQLException {
        if (!personne.existe(nom)) {
            throw new Tp6Exception("Impossible d'afficher, l'acteur " + nom
                    + " n'existe pas.");
        }

        return serie.serieAvecActeur(nom);
    }
}
