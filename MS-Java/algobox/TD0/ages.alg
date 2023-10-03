<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="SI (age>=10 ET age&lt;=11) ALORS"/>
    <extension extnom="inactif"/>
    <fonction fctcode="" fctetat="inactif"/>
    <F2 F2lignes="" F2defaut="" F2etat="inactif" F2para=""/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param epaisseurPoint="2" totalBoucles="5000000" epaisseurLigne="2" maxBoucle="500000" arrondiAuto="vrai" totalAffichages="1000" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#age" algoitem="age EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="2#age#pasliste" algoitem="LIRE age"/>
        <item code="6#age>=6 ET age&lt;=7" algoitem="SI (age>=6 ET age&lt;=7) ALORS">
            <item code="7#debutsi" algoitem="DEBUT_SI"/>
            <item code="4#La catégorie de l'enfant est Poussin#0" algoitem="AFFICHER &quot;La catégorie de l'enfant est Poussin&quot;"/>
            <item code="8#finsi" algoitem="FIN_SI"/>
            <item code="9#sinon" algoitem="SINON">
                <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                <item code="6#age>=8 ET age&lt;=9" algoitem="SI (age>=8 ET age&lt;=9) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="4#La catégorie de l'enfant est Pupille#0" algoitem="AFFICHER &quot;La catégorie de l'enfant est Pupille&quot;"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                    <item code="9#sinon" algoitem="SINON">
                        <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                        <item code="6#age>=10 ET age&lt;=11" algoitem="SI (age>=10 ET age&lt;=11) ALORS">
                            <item code="7#debutsi" algoitem="DEBUT_SI"/>
                            <item code="4#La gatégorie est Minime#0" algoitem="AFFICHER &quot;La gatégorie est Minime&quot;"/>
                            <item code="8#finsi" algoitem="FIN_SI"/>
                            <item code="9#sinon" algoitem="SINON">
                                <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                                <item code="6#age>12" algoitem="SI (age>12) ALORS">
                                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                                    <item code="4#La catégorie est Cadet#0" algoitem="AFFICHER &quot;La catégorie est Cadet&quot;"/>
                                    <item code="8#finsi" algoitem="FIN_SI"/>
                                </item>
                                <item code="11#finsinon" algoitem="FIN_SINON"/>
                            </item>
                        </item>
                        <item code="11#finsinon" algoitem="FIN_SINON"/>
                    </item>
                </item>
                <item code="11#finsinon" algoitem="FIN_SINON"/>
            </item>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
