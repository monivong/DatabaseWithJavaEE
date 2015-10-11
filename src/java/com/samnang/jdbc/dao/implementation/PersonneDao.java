package com.samnang.jdbc.dao.implementation;

import com.samnang.entites.Personne;
import com.samnang.jdbc.dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class PersonneDao extends Dao<Personne> {

    public PersonneDao(Connection c) {
        super(c);
    }
// S E C T I O N    C R E A T E
    @Override
    public boolean create(Personne x) {
        String req =    "INSERT INTO personne(`nom` , `prenom`, `age`, `taille`, `isAlive`) " + 
                        "VALUES ('" + x.getNom() + "','" + x.getPrenom() + "'," + x.getAge() + "," + 
                                    x.getTaille() + "," + x.getIsAlive() + ")";
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
			
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {                
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
// S E C T I O N    D E L E T E
    @Override
    public boolean delete(Personne x) {        
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(  "DELETE FROM personne " +
                                        "WHERE  id = " + x.getId() + " AND " +
                                                "nom = '" + x.getNom() + "' AND " + 
                                                "prenom = '" + x.getPrenom() + "' AND " + 
                                                "age = " + x.getAge() + " AND " +
                                                "taille = " + x.getTaille() + " AND " +
                                                "isAlive = " + x.getIsAlive() + " ");
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    public boolean deleteById(Personne x) {        
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM personne WHERE id = " + x.getId() );            
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    public boolean deleteByLastName(Personne x) {        
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM personne WHERE nom = '" + x.getNom() + "'");
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    public boolean deleteByFirstName(Personne x) {        
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM personne WHERE prenom = '" + x.getPrenom() + "'");
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    public boolean deleteByAge(Personne x) {        
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM personne WHERE age = " + x.getAge() );
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
// S E C T I O N    R E A D    
    public Personne read(String nom) {        
        PreparedStatement stm = null;
        try {
            //Statement stm = cnx.createStatement();
            //ResultSet r = stm.executeQuery("SELECT * FROM user WHERE numId = '" + id + "'");
            //Avec requête paramétrée :
            stm = cnx.prepareStatement("SELECT * FROM personne WHERE nom = ?");
            stm.setString( 1, nom );
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Personne p = new Personne();
                p.setId( r.getInt("id") );
                p.setNom( r.getString("nom") );
                p.setPrenom( r.getString("prenom") );
                p.setAge( r.getInt("age") );
                r.close();
                stm.close();
                return p;
            }
        } catch (SQLException exp) {
			
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {            
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    public Personne readById(int id) {        
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM personne WHERE id = ?");
            stm.setInt( 1, id );
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Personne p = new Personne();
                p.setId( r.getInt("id") );
                p.setNom( r.getString("nom") );
                p.setPrenom( r.getString("prenom") );
                p.setAge( r.getInt("age") );
                r.close();
                stm.close();
                return p;
            }
        } catch (SQLException exp) {
			
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {            
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    public Personne readByName(String nom) {        
        PreparedStatement stm = null;
        try {            
            stm = cnx.prepareStatement("SELECT * FROM personne WHERE nom = ?");
            stm.setString( 1, nom );
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Personne p = new Personne();
                p.setId( r.getInt("id") );
                p.setNom( r.getString("nom") );
                p.setPrenom( r.getString("prenom") );
                p.setAge( r.getInt("age") );
                r.close();
                stm.close();
                return p;
            }
        } catch (SQLException exp) {
			
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {            
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
// S E C T I O N    U P D A T E
    @Override
    public boolean update(Personne x) {
        Statement stm = null;
        try {
            String req = "UPDATE personne SET nom = '" + x.getNom() + "', prenom = '" + x.getPrenom() + "', age = " + x.getAge() + 
                        " WHERE id = " + x.getId();
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
			
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {            
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
// S E C T I O N    F I N D A L L
    @Override
    public List<Personne> findAll() {
        List<Personne> liste = new LinkedList<Personne>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM personne");
            while (r.next()) {
                Personne p = new Personne(r.getInt("id"), r.getString("nom"), r.getString("prenom"), 
                                        r.getInt("age"), r.getDouble("taille"), r.getBoolean("isAlive") );
                liste.add(p);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
}