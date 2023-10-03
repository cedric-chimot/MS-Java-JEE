<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER &quot;Z = &quot;"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2para="" F2lignes="" F2defaut="" F2etat="inactif"/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param totalAffichages="1000" nbDecimales="8" maxBoucle="500000" epaisseurLigne="2" arrondiAuto="vrai" epaisseurPoint="2" totalBoucles="5000000"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="X EST_DU_TYPE NOMBRE" code="1#NOMBRE#X"/>
        <item algoitem="Y EST_DU_TYPE NOMBRE" code="1#NOMBRE#Y"/>
        <item algoitem="Z EST_DU_TYPE NOMBRE" code="1#NOMBRE#Z"/>
        <item algoitem="N EST_DU_TYPE NOMBRE" code="1#NOMBRE#N"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="X PREND_LA_VALEUR 2" code="5#X#2#pasliste"/>
        <item algoitem="Y PREND_LA_VALEUR 10" code="5#Y#10#pasliste"/>
        <item algoitem="Z PREND_LA_VALEUR 7" code="5#Z#7#pasliste"/>
        <item algoitem="N PREND_LA_VALEUR X" code="5#N#X#pasliste"/>
        <item algoitem="X PREND_LA_VALEUR Z" code="5#X#Z#pasliste"/>
        <item algoitem="Z PREND_LA_VALEUR Y" code="5#Z#Y#pasliste"/>
        <item algoitem="Y PREND_LA_VALEUR N" code="5#Y#N#pasliste"/>
        <item algoitem="AFFICHER &quot;X = &quot;" code="4#X = #0"/>
        <item algoitem="AFFICHER X" code="3#X#1#pasliste"/>
        <item algoitem="AFFICHER &quot;Y = &quot;" code="4#Y = #0"/>
        <item algoitem="AFFICHER Y" code="3#Y#1#pasliste"/>
        <item algoitem="AFFICHER &quot;Z = &quot;" code="4#Z = #0"/>
        <item algoitem="AFFICHER Z" code="3#Z#0#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
