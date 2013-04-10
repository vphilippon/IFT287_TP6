package tp6;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class GestionFilm {

    private Film      film;
    private Personne  personne;
    private RoleFilm  roleFilm;
    private Connexion cx;

    public GestionFilm(Film film, Personne personne, RoleFilm roleFilm)
            throws Tp6Exception {
        if (film.getConnexion() != personne.getConnexion()) {
            throw new Tp6Exception("Connexions différentes dans GestionFilm");
        }
        this.cx = film.getConnexion();
        this.film = film;
        this.roleFilm = roleFilm;
        this.personne = personne;
    }

    public void ajoutFilm(String titre, Date dateSortie, String realisateur)
            throws Exception {
        try {
            // Vérifie si le film existe déja 
            if (film.existe(titre, dateSortie)) {
                throw new Tp6Exception("Impossible d'ajouter le film " + titre
                        + " paru le " + dateSortie + " : le film existe deja.");
            }
            // S'assure que le réalisateur existe
            if (!personne.existe(realisateur)) {
                throw new Tp6Exception("Impossible d'ajouter le film " + titre
                        + " paru le " + dateSortie + " : le realisateur " + realisateur
                        + " n'existe pas.");
            }
            Date realisateurNaissance = personne.getPersonne(realisateur).getDateNaissance();
            // S'assure que le réalisateur est né avant la sortie du film
            if (realisateurNaissance.after(dateSortie)) {
                throw new Tp6Exception("Impossible d'ajouter le film " + titre
                        + " paru le " + dateSortie + " : le realisateur " + realisateur
                        + " est nee le : " + realisateurNaissance
                        + " et ne peut pas avoir realiser un film cree le: " + dateSortie);
            }
            // Ajout du film dans la table des films
            film.ajouter(titre, dateSortie, realisateur);
            cx.commit();
        } catch (Exception e) {
            cx.rollback();
            throw e;
        }
    }

    public void supprimerFilm(String titre, Date dateSortie) throws Exception {
        try {
            // Vérifie si le film existe
            if (!film.existe(titre, dateSortie)) {
                throw new Tp6Exception("Impossible de supprimer le film " + titre
                        + " paru le " + dateSortie + " : le film n'existe pas.");
            }
            //Verifie si un role est relier au film
            if (roleFilm.aDesRoles(titre, dateSortie)) {
                throw new Tp6Exception("Impossible de supprimer le film " + titre
                        + " paru le " + dateSortie
                        + " : au moins un role existe pour celui-ci.");
            }
            // Supression du film dans la table Film
            System.out.println(film.enlever(titre, dateSortie) + " film supprimé");
            cx.commit();
        } catch (Exception e) {
            cx.rollback();
            throw e;
        }
    }

    public void ajoutDescFilm(String titre, Date anneeSortie, String description,
            int duree) throws Exception {
        try {
            //si le film n'existe pas
            if (!film.existe(titre, anneeSortie)) {
                throw new Tp6Exception("Impossible d'ajouter la description "
                        + "pour le film " + titre + " paru le " + anneeSortie
                        + " : le film n'existe pas.");
            }
            film.ajouterDescription(titre, anneeSortie, description, duree);
            cx.commit();
        } catch (Exception e) {
            cx.rollback();
            throw e;
        }
    }

    public void ajoutActeurFilm(String titre, Date anneeSortie, String nomActeur,
            String role) throws Exception {
        try {
            //verifie si l acteur existe
            if (!personne.existe(nomActeur)) {
                throw new Tp6Exception("Impossible d'ajouter l'acteur " + nomActeur
                        + " au film " + titre + " paru le " + anneeSortie
                        + " : l'acteur n'existe pas.");
            }

            //verifie si le film existe
            if (!film.existe(titre, anneeSortie)) {
                throw new Tp6Exception("Impossible d'ajouter l'acteur " + nomActeur
                        + " au film " + titre + " paru le " + anneeSortie
                        + " : le film n'existe pas.");
            }

            //verifie que lMacteur est nee avant la sortie du film
            TuplePersonne acteur = personne.getPersonne(nomActeur);
            if (acteur.getDateNaissance().after(anneeSortie)) {
                throw new Tp6Exception("Impossible d'ajouter l'acteur " + nomActeur
                        + " au film " + titre + " paru le " + anneeSortie
                        + " : l'acteur est nee avant la date de sortie du film.");
            }

            //verifie que le role n'existe pas deja pour cette acteur
            if (roleFilm.existe(nomActeur, titre, anneeSortie, role)) {
                throw new Tp6Exception("Impossible d'ajouter l'acteur " + nomActeur
                        + " au film " + titre + " paru le " + anneeSortie
                        + " : l'acteur joue deja un role dans ce film.");
            }

            //verifie que le role n'existe pas deja pour un autre acteur
            if (roleFilm.existe(titre, anneeSortie, role)) {
                throw new Tp6Exception("Impossible d'ajouter l'acteur " + nomActeur
                        + " au film " + titre + " paru le " + anneeSortie
                        + " : un autre acteur joue deja le role + " + role
                        + " dans ce film.");
            }

            roleFilm.ajouter(nomActeur, titre, anneeSortie, role);
            cx.commit();
        } catch (Exception e) {
            cx.rollback();
            throw e;
        }
    }

    public List<TuplePersonne> afficherActeurDeFilm(String titre, Date anneeSortie)
            throws Tp6Exception, SQLException {
        if (!film.existe(titre, anneeSortie)) {
            throw new Tp6Exception("Impossible d'afficher les acteurs du film " + titre
                    + " paru le " + anneeSortie + " : le film n'existe pas.");
        }

        return roleFilm.getActeurs(titre, anneeSortie);
    }
}
