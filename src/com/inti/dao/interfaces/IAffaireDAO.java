package com.inti.dao.interfaces;

import com.inti.entities.Affaire;

public interface IAffaireDAO {
 
	Affaire getAffaireByTitre(String titre);
}
