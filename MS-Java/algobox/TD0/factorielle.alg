<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="facto PREND_LA_VALEUR facto*i" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2defaut="" F2etat="inactif" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param arrondiAuto="vrai" nbDecimales="8" totalBoucles="5000000" epaisseurLigne="2" epaisseurPoint="2" maxBoucle="500000" totalAffichages="1000"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#N" algoitem="N EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#facto" algoitem="facto EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="2#N#pasliste" algoitem="LIRE N"/>
        <item code="5#facto#1#pasliste" algoitem="facto PREND_LA_VALEUR 1"/>
        <item code="12#i#1#N" algoitem="POUR i ALLANT_DE 1 A N">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="5#facto#facto*i#pasliste" algoitem="facto PREND_LA_VALEUR facto*i"/>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="3#facto#0#pasliste" algoitem="AFFICHER facto"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
