<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER i"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2lignes="" F2defaut="" F2etat="inactif" F2para=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param epaisseurPoint="2" totalBoucles="5000000" epaisseurLigne="2" maxBoucle="500000" arrondiAuto="vrai" totalAffichages="1000" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#N" algoitem="N EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#i" algoitem="i EST_DU_TYPE NOMBRE"/>
        <item code="1#LISTE#tableau" algoitem="tableau EST_DU_TYPE LISTE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="2#N#pasliste" algoitem="LIRE N"/>
        <item code="12#i#0#N" algoitem="POUR i ALLANT_DE 0 A N">
            <item code="13#debutpour" algoitem="DEBUT_POUR"/>
            <item code="2#tableau#N" algoitem="LIRE tableau[N]"/>
            <item code="5#i#tableau[N]#pasliste" algoitem="i PREND_LA_VALEUR tableau[N]"/>
            <item code="14#finpour" algoitem="FIN_POUR"/>
        </item>
        <item code="3#i#0#pasliste" algoitem="AFFICHER i"/>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
