package University;

public abstract class Personne {
	
	    private String nom;
	    private String prenom;
	    private String adresse;
	    private String email;
	    private String numeroTelephone;
	    private String titre;
	    private String matricule;
	    
	    public Personne(String nom, String prenom, String adresse, String email, String numeroTelephone, String titre, String matricule) {
	        this.nom = nom;
	        this.prenom = prenom;
	        this.adresse = adresse;
	        this.email = email;
	        this.numeroTelephone = numeroTelephone;
	        this.titre = titre;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getPrenom() {
	        return prenom;
	    }

	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }

	    public String getAdresse() {
	        return adresse;
	    }

	    public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getNumeroTelephone() {
	        return numeroTelephone;
	    }

	    public void setNumeroTelephone(String numeroTelephone) {
	        this.numeroTelephone = numeroTelephone;
	    }

	    public String getTitre() {
	        return titre;
	    }

	    public void setTitre(String titre) {
	        this.titre = titre;
	    }

	    public String getMatricule() {
	        return matricule;
	    }

	    public void setMatricule(String matricule) {
	        this.matricule = matricule;
	    }

	    public abstract void afficherDetails();
	}


