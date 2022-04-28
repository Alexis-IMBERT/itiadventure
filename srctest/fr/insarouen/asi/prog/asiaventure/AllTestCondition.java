package fr.insarouen.asi.prog.asiaventure;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runner.RunWith;
import fr.insarouen.asi.prog.asiaventure.TestConditionDeFinVivantDansPiece;
import fr.insarouen.asi.prog.asiaventure.TestConditionDeFinVivantMort;
import fr.insarouen.asi.prog.asiaventure.TestConditionDeFinVivantPossedeObjets;
import fr.insarouen.asi.prog.asiaventure.TestConditionDeFinVivantDansPieceEtPossedeObjets;
import fr.insarouen.asi.prog.asiaventure.TestConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction;

@RunWith(Suite.class)
@SuiteClasses({
    TestConditionDeFinVivantDansPiece.class,
    TestConditionDeFinVivantDansPieceEtPossedeObjets.class,
    TestConditionDeFinVivantMort.class,
    TestConditionDeFinVivantPossedeObjets.class,
    TestConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction.class
})
public class AllTestCondition{}