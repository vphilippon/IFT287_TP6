package tp6;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class GestionSerie {

    private Serie       serie;
    private Episode     episode;
    private Personne    personne;
    private RoleEpisode roleEpisode;
    private Connexion   cx;

    public GestionSerie(Serie serie, Episode episode, Personne personne,
                        RoleEpisode roleEpisode) throws Tp6Exception {
        this.cx = personne.getConnexion();
        if (cx != serie.getConnexion() || cx != episode.getConnexion()
                || cx != personne.getConnexion() || cx != roleEpisode.getConnexion()) {
            throw new Tp6Exception(
                    "Les instances de connexions dans GestionPersonne sont différentes");
        }
        this.episode = episode;
        this.personne = personne;
        this.serie = serie;
        this.roleEpisode = roleEpisode;
    }

    public void ajoutSerie(String titre, Date dateSortie, String realisateur,
            String description, int nbSaison) throws Exception {
        try {
            // Vérifie si le film existe déja 
            if (serie.existe(titre, dateSortie)) {
                throw new Tp6Exception("Impossible d'ajouter la serie " + titre
                        + " paru le " + dateSortie + " : la serie existe deja.");
            }
            // S'assure que le réalisateur existe
            if (!personne.existe(realisateur)) {
                throw new Tp6Exception("Impossible d'ajouter la serie " + titre
                        + " paru le " + dateSortie + " : le realisateur " + realisateur
                        + " n'existe pas.");
            }
            Date realisateurNaissance = personne.getPersonne(realisateur).getDateNaissance();
            // S'assure que le réalisateur est né avant la sortie du film
            if (realisateurNaissance.after(dateSortie)) {
                throw new Tp6Exception("Impossible d'ajouter la serie " + titre
                        + " paru le " + dateSortie + " : le realisateur " + realisateur
                        + " est nee le " + realisateurNaissance
                        + " et ne peut pas participer a un film cree le: " + dateSortie);
            }
            // Ajout de la serie la table des series
            serie.ajouter(titre, dateSortie, realisateur, description, nbSaison);
            cx.commit();
        } catch (Exception e) {
            cx.rollback();
            throw e;
        }
    }

    public void ajoutDescSerie(String titre, Date anneeSortie, String description)
            throws Exception {
        try {
            //si la serie n'existe pas
            if (!serie.existe(titre, anneeSortie)) {
                throw new Tp6Exception("Impossible d'ajouter la série, la série " + titre
                        + " paru le " + anneeSortie + " n'existe pas.");
            }
            serie.ajouterDescription(titre, anneeSortie, description);
            cx.commit();
        } catch (Exception e) {
            cx.rollback();
            throw e;
        }
    }

    public void ajoutEpisode(String titre, String titreSerie, Date anneeSortieSerie,
            int noSaison, int noEpisode, String description, Date dateDiffusion)
            throws Exception {
        try {
            // Vérifie si la serie existe
            if (!serie.existe(titreSerie, anneeSortieSerie)) {
                throw new Tp6Exception("Impossible d'ajouter l'episode " + noEpisode
                        + " saison " + noSaison + " de la serie " + titreSerie
                        + " paru le " + anneeSortieSerie + " : la serie n'existe pas.");
            }
            //verifie si l'episode existe deja
            if (episode.existe(titreSerie, anneeSortieSerie, noSaison, noEpisode)) {
                throw new Tp6Exception("Impossible d'ajouter l'episode " + noEpisode
                        + " saison " + noSaison + " de la serie " + titreSerie
                        + " paru le " + anneeSortieSerie + " : l'episode existe deja.");
            }
            // verifie si le no saison est valide
            if (noSaison < 1
                    || noSaison > serie.getSerie(titreSerie, anneeSortieSerie).getNbSaison()) {
                throw new Tp6Exception("Impossible d'ajouter l'episode " + noEpisode
                        + " saison " + noSaison + " de la serie " + titreSerie
                        + " paru le " + anneeSortieSerie + " : il n'y a pas de saison "
                        + noSaison);
            }
            //verifie que le no episode est valide
            if (noEpisode < 1) {
                throw new Tp6Exception("Impossible d'ajouter l'episode " + noEpisode
                        + " saison " + noSaison + " de la serie " + titreSerie
                        + " paru le " + anneeSortieSerie
                        + " : le numero d'episode doit etre plus grand ou egal a 1.");
            }

            // S'assure que l'épisode d'avant existe
            if (noEpisode > 1) {
                if (!episode.existe(titreSerie, anneeSortieSerie, noSaison, noEpisode - 1)) {
                    throw new Tp6Exception("Impossible d'ajouter l'episode " + noEpisode
                            + " saison " + noSaison + " de la serie " + titreSerie
                            + " paru le " + anneeSortieSerie + " : l'episode No "
                            + (noEpisode - 1) + " est manquant.");
                }
            }
            // Ajout de l'épisode dans la table des épisodes
            episode.ajouter(titre, titreSerie, anneeSortieSerie, noSaison, noEpisode,
                    description, dateDiffusion);
            cx.commit();
        } catch (Exception e) {
            cx.rollback();
            throw e;
        }
    }

    public void ajoutRoleAEpisode(String serieTitre, Date serieDate, int noSaison,
            int noEpisode, String acteur, String roleActeur) throws Exception {
        try {
            //verifie que la serie existe
            if (!serie.existe(serieTitre, serieDate)) {
                throw new Tp6Exception("Impossible d'ajouter le role a l'acteur "
                        + acteur + " pour l'episode " + noEpisode + " saison " + noSaison
                        + " de la serie " + serieTitre + " paru le " + serieDate
                        + " : la serie n'existe pas.");
            }
            //verifie que l'episode existe
            if (!episode.existe(serieTitre, serieDate, noSaison, noEpisode)) {
                throw new Tp6Exception("Impossible d'ajouter le role a l'acteur "
                        + acteur + " pour l'episode " + noEpisode + " saison " + noSaison
                        + " de la serie " + serieTitre + " paru le " + serieDate
                        + " : l'episode n'existe pas.");
            }
            //verifie que l'acteur existe
            if (!personne.existe(acteur)) {
                throw new Tp6Exception("Impossible d'ajouter le role a l'acteur "
                        + acteur + " pour l'episode " + noEpisode + " saison " + noSaison
                        + " de la serie " + serieTitre + " paru le " + serieDate
                        + " : l'acteur n'existe pas.");
            }

            //verifie que l'acteur etait nee
            TuplePersonne tupleActeur = personne.getPersonne(acteur);
            if (tupleActeur.getDateNaissance().after(serieDate)) {
                throw new Tp6Exception("Impossible d'ajouter le role a l'acteur "
                        + acteur + " pour l'episode " + noEpisode + " saison " + noSaison
                        + " de la serie " + serieTitre + " paru le " + serieDate
                        + " : l'acteur est nee le: " + tupleActeur.getDateNaissance()
                        + " et ne peut pas participer a une serie cree le: " + serieDate
                        + ".");
            }
            //verifie que l'acteur n'a pas deja le role
            if (roleEpisode.existe(serieTitre, serieDate, noSaison, noEpisode, acteur)) {
                throw new Tp6Exception("Impossible d'ajouter le role a l'acteur "
                        + acteur + " pour l'episode " + noEpisode + " saison " + noSaison
                        + " de la serie " + serieTitre + " paru le " + serieDate
                        + " : l'acteur a deja un role dans l'episode.");
            }
            //verifie qu'un autre acteur n'a pas deja le role
            if (roleEpisode.existeRole(serieTitre, serieDate, noSaison, noEpisode,
                    roleActeur)) {
                throw new Tp6Exception("Impossible d'ajouter le role a l'acteur "
                        + acteur + " pour l'episode " + noEpisode + " saison " + noSaison
                        + " de la serie " + serieTitre + " paru le " + serieDate
                        + " : un autre acteur a deja le role " + roleActeur + ".");
            }

            roleEpisode.ajouter(serieTitre, serieDate, noSaison, noEpisode, acteur,
                    roleActeur);
            cx.commit();
        } catch (Exception e) {
            cx.rollback();
            throw e;
        }
    }

    public List<TuplePersonne> afficherActeursSerie(String serieTitre, Date serieDate)
            throws SQLException, Tp6Exception {
        if (!serie.existe(serieTitre, serieDate)) {
            throw new Tp6Exception("Impossible d'afficher les acteurs de la serie "
                    + serieTitre + " paru le " + serieDate + " : la serie n'existe pas.");
        }
        return personne.acteursDeSerie(serieTitre, serieDate);
    }
}
