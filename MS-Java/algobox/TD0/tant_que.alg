<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER &quot;Correct !&quot;"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2lignes="" F2defaut="" F2etat="inactif" F2para=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param epaisseurPoint="2" totalBoucles="5000000" epaisseurLigne="2" maxBoucle="500000" arrondiAuto="vrai" totalAffichages="1000" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#N" algoitem="N EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#nb" algoitem="nb EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="5#nb#13#pasliste" algoitem="nb PREND_LA_VALEUR 13"/>
        <item code="2#N#pasliste" algoitem="LIRE N"/>
        <item code="15#N!=nb" algoitem="TANT_QUE (N!=nb) FAIRE">
            <item code="16#debuttantque" algoitem="DEBUT_TANT_QUE"/>
            <item code="6#N&lt;nb" algoitem="SI (N&lt;nb) ALORS">
                <item code="7#debutsi" algoitem="DEBUT_SI"/>
                <item code="4#Plus grand !#0" algoitem="AFFICHER &quot;Plus grand !&quot;"/>
                <item code="2#N#pasliste" algoitem="LIRE N"/>
                <item code="8#finsi" algoitem="FIN_SI"/>
                <item code="9#sinon" algoitem="SINON">
                    <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                    <item code="6#N>nb" algoitem="SI (N>nb) ALORS">
                        <item code="7#debutsi" algoitem="DEBUT_SI"/>
                        <item code="4#Plus petit !#0" algoitem="AFFICHER &quot;Plus petit !&quot;"/>
                        <item code="2#N#pasliste" algoitem="LIRE N"/>
                        <item code="8#finsi" algoitem="FIN_SI"/>
                    </item>
                    <item code="11#finsinon" algoitem="FIN_SINON"/>
                </item>
            </item>
            <item code="17#fintantque" algoitem="FIN_TANT_QUE"/>
        </item>
        <item code="6#N=nb" algoitem="SI (N=nb) ALORS">
            <item code="7#debutsi" algoitem="DEBUT_SI"/>
            <item code="4#Correct !#0" algoitem="AFFICHER &quot;Correct !&quot;"/>
            <item code="8#finsi" algoitem="FIN_SI"/>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
