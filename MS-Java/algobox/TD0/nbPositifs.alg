<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="SI (nombre1&lt;0 ET nombre2&lt;0) ALORS"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2lignes="" F2defaut="" F2etat="inactif" F2para=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param epaisseurPoint="2" totalBoucles="5000000" epaisseurLigne="2" maxBoucle="500000" arrondiAuto="vrai" totalAffichages="1000" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#nombre1" algoitem="nombre1 EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#nombre2" algoitem="nombre2 EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="2#nombre1#pasliste" algoitem="LIRE nombre1"/>
        <item code="2#nombre2#pasliste" algoitem="LIRE nombre2"/>
        <item code="6#nombre1&lt;0 ET nombre2&lt;0" algoitem="SI (nombre1&lt;0 ET nombre2&lt;0) ALORS">
            <item code="7#debutsi" algoitem="DEBUT_SI"/>
            <item code="4#Le produit des 2 nombres  est positif#0" algoitem="AFFICHER &quot;Le produit des 2 nombres  est positif&quot;"/>
            <item code="8#finsi" algoitem="FIN_SI"/>
            <item code="9#sinon" algoitem="SINON">
                <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                <item code="6#(nombre1&lt;0 ET nombre2>0) OU (nombre1>0 ET nombre2&lt;0)" algoitem="SI ((nombre1&lt;0 ET nombre2>0) OU (nombre1>0 ET nombre2&lt;0)) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="4#Le produit des 2 nombres est négatif#0" algoitem="AFFICHER &quot;Le produit des 2 nombres est négatif&quot;"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                    <item code="9#sinon" algoitem="SINON">
                        <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                        <item code="4#Le produit des 2 nombres est positif#0" algoitem="AFFICHER &quot;Le produit des 2 nombres est positif&quot;"/>
                        <item code="11#finsinon" algoitem="FIN_SINON"/>
                    </item>
                </item>
                <item code="11#finsinon" algoitem="FIN_SINON"/>
            </item>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
