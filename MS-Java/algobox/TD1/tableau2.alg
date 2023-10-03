<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="min PREND_LA_VALEUR t[j]"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2etat="inactif" F2defaut="" F2lignes=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param maxBoucle="500000" epaisseurPoint="2" totalAffichages="1000" totalBoucles="5000000" nbDecimales="8" arrondiAuto="vrai" epaisseurLigne="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="i EST_DU_TYPE NOMBRE" code="1#NOMBRE#i"/>
        <item algoitem="j EST_DU_TYPE NOMBRE" code="1#NOMBRE#j"/>
        <item algoitem="n EST_DU_TYPE NOMBRE" code="1#NOMBRE#n"/>
        <item algoitem="t EST_DU_TYPE LISTE" code="1#LISTE#t"/>
        <item algoitem="min EST_DU_TYPE NOMBRE" code="1#NOMBRE#min"/>
        <item algoitem="k EST_DU_TYPE NOMBRE" code="1#NOMBRE#k"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="LIRE n" code="2#n#pasliste"/>
        <item algoitem="POUR i ALLANT_DE 1 A n" code="12#i#1#n">
            <item algoitem="DEBUT_POUR" code="13#debutpour"/>
            <item algoitem="LIRE t[i]" code="2#t#i"/>
            <item algoitem="FIN_POUR" code="14#finpour"/>
        </item>
        <item algoitem="LIRE i" code="2#i#pasliste"/>
        <item algoitem="LIRE j" code="2#j#pasliste"/>
        <item algoitem="SI (j>n) ALORS" code="6#j>n">
            <item algoitem="DEBUT_SI" code="7#debutsi"/>
            <item algoitem="j PREND_LA_VALEUR n" code="5#j#n#pasliste"/>
            <item algoitem="FIN_SI" code="8#finsi"/>
        </item>
        <item algoitem="POUR k ALLANT_DE i A j" code="12#k#i#j">
            <item algoitem="DEBUT_POUR" code="13#debutpour"/>
            <item algoitem="SI (t[i]>=min et t[j]&lt;=min) ALORS" code="6#t[i]>=min et t[j]&lt;=min">
                <item algoitem="DEBUT_SI" code="7#debutsi"/>
                <item algoitem="min PREND_LA_VALEUR t[j]" code="5#min#t[j]#pasliste"/>
                <item algoitem="FIN_SI" code="8#finsi"/>
            </item>
            <item algoitem="FIN_POUR" code="14#finpour"/>
        </item>
        <item algoitem="AFFICHER min" code="3#min#0#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
