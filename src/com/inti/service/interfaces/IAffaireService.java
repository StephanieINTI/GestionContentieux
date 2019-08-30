package com.inti.service.interfaces;

import com.inti.entities.Affaire;

public interface IAffaireService extends IService<Affaire>{

	Affaire getAffaireByTitre(String titre);
}
