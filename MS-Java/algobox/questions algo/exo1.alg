<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="quotient PREND_LA_VALEUR floor(A/B)" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2defaut="" F2lignes="" F2etat="inactif"/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param arrondiAuto="vrai" epaisseurLigne="2" nbDecimales="8" totalBoucles="5000000" epaisseurPoint="2" totalAffichages="1000" maxBoucle="500000"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="A EST_DU_TYPE NOMBRE" code="1#NOMBRE#A"/>
        <item algoitem="B EST_DU_TYPE NOMBRE" code="1#NOMBRE#B"/>
        <item algoitem="reste EST_DU_TYPE NOMBRE" code="1#NOMBRE#reste"/>
        <item algoitem="quotient EST_DU_TYPE NOMBRE" code="1#NOMBRE#quotient"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="LIRE A" code="2#A#pasliste"/>
        <item algoitem="LIRE B" code="2#B#pasliste"/>
        <item algoitem="reste PREND_LA_VALEUR A%B" code="5#reste#A%B#pasliste"/>
        <item algoitem="quotient PREND_LA_VALEUR floor(A/B)" code="5#quotient#floor(A/B)#pasliste"/>
        <item algoitem="AFFICHER &quot;Reste : &quot;" code="4#Reste : #0"/>
        <item algoitem="AFFICHER reste" code="3#reste#1#pasliste"/>
        <item algoitem="AFFICHER &quot;Quotient : &quot;" code="4#Quotient : #0"/>
        <item algoitem="AFFICHER quotient" code="3#quotient#0#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
