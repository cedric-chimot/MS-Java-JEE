<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FONCTIONS_UTILISEES" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2defaut="" F2etat="inactif" F2lignes="" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param nbDecimales="8" totalBoucles="5000000" arrondiAuto="vrai" totalAffichages="1000" epaisseurLigne="2" maxBoucle="500000" epaisseurPoint="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="prixHT EST_DU_TYPE NOMBRE" code="1#NOMBRE#prixHT"/>
        <item algoitem="prixTTC EST_DU_TYPE NOMBRE" code="1#NOMBRE#prixTTC"/>
        <item algoitem="article EST_DU_TYPE NOMBRE" code="1#NOMBRE#article"/>
        <item algoitem="TVA EST_DU_TYPE NOMBRE" code="1#NOMBRE#TVA"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="LIRE article" code="2#article#pasliste"/>
        <item algoitem="LIRE prixHT" code="2#prixHT#pasliste"/>
        <item algoitem="LIRE TVA" code="2#TVA#pasliste"/>
        <item algoitem="AFFICHER &quot;Vous avez acheté &quot;" code="4#Vous avez acheté #0"/>
        <item algoitem="AFFICHER article" code="3#article#0#pasliste"/>
        <item algoitem="AFFICHER &quot; article(s)&quot;" code="4# article(s)#1"/>
        <item algoitem="AFFICHER &quot;pour un montant de &quot;" code="4#pour un montant de #0"/>
        <item algoitem="AFFICHERCALCUL ((prixHT*article)*(1+TVA))" code="20#((prixHT*article)*(1+TVA))#0"/>
        <item algoitem="AFFICHER &quot; € TTC&quot;" code="4# € TTC#0"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
