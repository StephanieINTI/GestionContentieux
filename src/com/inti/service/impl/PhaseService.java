package com.inti.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Phase;
import com.inti.service.interfaces.IPhaseService;

@Service
@Transactional
public class PhaseService extends ManagerService<Phase> implements IPhaseService{

}
