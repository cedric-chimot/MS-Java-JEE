<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="SI (T[J]&lt;=min) ALORS"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2etat="inactif" F2defaut="" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param maxBoucle="500000" epaisseurPoint="2" totalAffichages="1000" totalBoucles="5000000" nbDecimales="8" arrondiAuto="vrai" epaisseurLigne="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="T EST_DU_TYPE LISTE" code="1#LISTE#T"/>
        <item algoitem="i EST_DU_TYPE NOMBRE" code="1#NOMBRE#i"/>
        <item algoitem="min EST_DU_TYPE NOMBRE" code="1#NOMBRE#min"/>
        <item algoitem="max EST_DU_TYPE NOMBRE" code="1#NOMBRE#max"/>
        <item algoitem="N EST_DU_TYPE NOMBRE" code="1#NOMBRE#N"/>
        <item algoitem="J EST_DU_TYPE NOMBRE" code="1#NOMBRE#J"/>
        <item algoitem="indiceMin EST_DU_TYPE NOMBRE" code="1#NOMBRE#indiceMin"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="LIRE N" code="2#N#pasliste"/>
        <item algoitem="POUR i ALLANT_DE 1 A N" code="12#i#1#N">
            <item algoitem="DEBUT_POUR" code="13#debutpour"/>
            <item algoitem="LIRE T[i]" code="2#T#i"/>
            <item algoitem="FIN_POUR" code="14#finpour"/>
        </item>
        <item algoitem="min PREND_LA_VALEUR T[1]" code="5#min#T[1]#pasliste"/>
        <item algoitem="indiceMin PREND_LA_VALEUR 1" code="5#indiceMin#1#pasliste"/>
        <item algoitem="POUR J ALLANT_DE 2 A N" code="12#J#2#N">
            <item algoitem="DEBUT_POUR" code="13#debutpour"/>
            <item algoitem="SI (T[J]&lt;=min) ALORS" code="6#T[J]&lt;=min">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="min PREND_LA_VALEUR T[J]" code="5#min#T[J]#pasliste"/>
                <item algoitem="indiceMin PREND_LA_VALEUR J" code="5#indiceMin#J#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
            </item>
            <item algoitem="FIN_POUR" code="14#finpour"/>
        </item>
        <item algoitem="AFFICHER &quot;Nombre plus petit : &quot;" code="4#Nombre plus petit : #0"/>
        <item algoitem="AFFICHER min" code="3#min#1#pasliste"/>
        <item algoitem="AFFICHER &quot;Indice du plus petit : &quot;" code="4#Indice du plus petit : #0"/>
        <item algoitem="AFFICHER indiceMin" code="3#indiceMin#0#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
