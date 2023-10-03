<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="moy PREND_LA_VALEUR som/(j-i+1)" texte=""/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2etat="inactif" F2para="" F2defaut="" F2lignes=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param maxBoucle="500000" arrondiAuto="vrai" totalAffichages="1000" epaisseurPoint="2" totalBoucles="5000000" nbDecimales="8" epaisseurLigne="2"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="t EST_DU_TYPE LISTE" code="1#LISTE#t"/>
        <item algoitem="som EST_DU_TYPE NOMBRE" code="1#NOMBRE#som"/>
        <item algoitem="moy EST_DU_TYPE NOMBRE" code="1#NOMBRE#moy"/>
        <item algoitem="n EST_DU_TYPE NOMBRE" code="1#NOMBRE#n"/>
        <item algoitem="i EST_DU_TYPE NOMBRE" code="1#NOMBRE#i"/>
        <item algoitem="k EST_DU_TYPE NOMBRE" code="1#NOMBRE#k"/>
        <item algoitem="j EST_DU_TYPE NOMBRE" code="1#NOMBRE#j"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="LIRE n" code="2#n#pasliste"/>
        <item algoitem="POUR i ALLANT_DE 0 A n-1" code="12#i#0#n-1">
            <item algoitem="DEBUT_POUR" code="13#debutpour"/>
            <item algoitem="LIRE t[i]" code="2#t#i"/>
            <item algoitem="som PREND_LA_VALEUR som+t[i]" code="5#som#som+t[i]#pasliste"/>
            <item algoitem="FIN_POUR" code="14#finpour"/>
        </item>
        <item algoitem="AFFICHER &quot;Somme tableau : &quot;" code="4#Somme tableau : #0"/>
        <item algoitem="AFFICHER som" code="3#som#1#pasliste"/>
        <item algoitem="moy PREND_LA_VALEUR ALGOBOX_ARRONDIR((som/n),2)" code="5#moy#ALGOBOX_ARRONDIR((som/n),2)#pasliste"/>
        <item algoitem="AFFICHER &quot;Moyenne tableau : &quot;" code="4#Moyenne tableau : #0"/>
        <item algoitem="AFFICHER moy" code="3#moy#0#pasliste"/>
        <item algoitem="som PREND_LA_VALEUR 0" code="5#som#0#pasliste"/>
        <item algoitem="moy PREND_LA_VALEUR 0" code="5#moy#0#pasliste"/>
        <item algoitem="LIRE i" code="2#i#pasliste"/>
        <item algoitem="k PREND_LA_VALEUR i" code="5#k#i#pasliste"/>
        <item algoitem="TANT_QUE (t[k]!=(-1) et k&lt;n) FAIRE" code="15#t[k]!=(-1) et k&lt;n">
            <item algoitem="DEBUT_TANT_QUE" code="16#debuttantque"/>
            <item algoitem="k PREND_LA_VALEUR k+1" code="5#k#k+1#pasliste"/>
            <item algoitem="FIN_TANT_QUE" code="17#fintantque"/>
        </item>
        <item algoitem="SI (k==n) ALORS" code="6#k==n">
            <item algoitem="DEBUT_SI" code="7#debutsi"/>
            <item algoitem="j PREND_LA_VALEUR n-1" code="5#j#n-1#pasliste"/>
            <item algoitem="FIN_SI" code="8#finsi"/>
            <item algoitem="SINON" code="9#sinon">
                <item algoitem="DEBUT_SINON" code="10#debutsinon"/>
                <item algoitem="j PREND_LA_VALEUR k-1" code="5#j#k-1#pasliste"/>
                <item algoitem="FIN_SINON" code="11#finsinon"/>
            </item>
        </item>
        <item algoitem="POUR k ALLANT_DE i A j" code="12#k#i#j">
            <item algoitem="DEBUT_POUR" code="13#debutpour"/>
            <item algoitem="som PREND_LA_VALEUR som+t[k]" code="5#som#som+t[k]#pasliste"/>
            <item algoitem="FIN_POUR" code="14#finpour"/>
        </item>
        <item algoitem="AFFICHER som" code="3#som#1#pasliste"/>
        <item algoitem="moy PREND_LA_VALEUR som/(j-i+1)" code="5#moy#som/(j-i+1)#pasliste"/>
        <item algoitem="AFFICHER moy" code="3#moy#0#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
