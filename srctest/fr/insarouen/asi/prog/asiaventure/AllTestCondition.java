package fr.insarouen.asi.prog.asiaventure;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TestConditionDeFinVivantDansPiece.class,
    TestConditionDeFinVivantDansPiece.class,
    TestConditionDeFinVivantDansPieceEtPossedeObjets.class,
    TestConditionDeFinVivantMort.class,
    TestConditionDeFinVivantPossedeObjets.class,
    TestConditionDeFinVivantPossedeObjets.class,
    TestConditionDeFinVivantMort.class,
    TestConditionDeFinVivantPossedeObjets.class,
    TestConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction.class
})
public class AllTestCondition{}