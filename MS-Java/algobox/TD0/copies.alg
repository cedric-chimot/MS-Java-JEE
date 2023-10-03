<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="" courant="AFFICHER &quot; €&quot;"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2defaut="" F2lignes="" F2etat="inactif"/>
    <repere repetat="inactif" repcode="-10#10#-10#10#2#2"/>
    <param maxBoucle="500000" arrondiAuto="vrai" totalBoucles="5000000" epaisseurLigne="2" totalAffichages="1000" epaisseurPoint="2" nbDecimales="8"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#nbPhotos" algoitem="nbPhotos EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#prixPhotos" algoitem="prixPhotos EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#prixTotal" algoitem="prixTotal EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="2#nbPhotos#pasliste" algoitem="LIRE nbPhotos"/>
        <item code="6#nbPhotos&lt;=10" algoitem="SI (nbPhotos&lt;=10) ALORS">
            <item code="7#debutsi" algoitem="DEBUT_SI"/>
            <item code="5#prixPhotos#0.5#pasliste" algoitem="prixPhotos PREND_LA_VALEUR 0.5"/>
            <item code="5#prixTotal#prixPhotos*nbPhotos#pasliste" algoitem="prixTotal PREND_LA_VALEUR prixPhotos*nbPhotos"/>
            <item code="4#Le nombre de copie est de : #0" algoitem="AFFICHER &quot;Le nombre de copie est de : &quot;"/>
            <item code="3#nbPhotos#1#pasliste" algoitem="AFFICHER nbPhotos"/>
            <item code="4#Le prix total est de : #0" algoitem="AFFICHER &quot;Le prix total est de : &quot;"/>
            <item code="3#prixTotal#0#pasliste" algoitem="AFFICHER prixTotal"/>
            <item code="4# €#0" algoitem="AFFICHER &quot; €&quot;"/>
            <item code="8#finsi" algoitem="FIN_SI"/>
            <item code="9#sinon" algoitem="SINON">
                <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                <item code="6#nbPhotos>10 et nbPhotos&lt;=20" algoitem="SI (nbPhotos>10 et nbPhotos&lt;=20) ALORS">
                    <item code="7#debutsi" algoitem="DEBUT_SI"/>
                    <item code="5#prixPhotos#0.4#pasliste" algoitem="prixPhotos PREND_LA_VALEUR 0.4"/>
                    <item code="5#prixTotal#prixPhotos*nbPhotos#pasliste" algoitem="prixTotal PREND_LA_VALEUR prixPhotos*nbPhotos"/>
                    <item code="4#Le nombre de copie est de : #0" algoitem="AFFICHER &quot;Le nombre de copie est de : &quot;"/>
                    <item code="3#nbPhotos#1#pasliste" algoitem="AFFICHER nbPhotos"/>
                    <item code="4#Le prix total est de : #0" algoitem="AFFICHER &quot;Le prix total est de : &quot;"/>
                    <item code="3#prixTotal#0#pasliste" algoitem="AFFICHER prixTotal"/>
                    <item code="4# €#0" algoitem="AFFICHER &quot; €&quot;"/>
                    <item code="8#finsi" algoitem="FIN_SI"/>
                    <item code="9#sinon" algoitem="SINON">
                        <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                        <item code="6#nbPhotos>20" algoitem="SI (nbPhotos>20) ALORS">
                            <item code="7#debutsi" algoitem="DEBUT_SI"/>
                            <item code="5#prixPhotos#0.3#pasliste" algoitem="prixPhotos PREND_LA_VALEUR 0.3"/>
                            <item code="5#prixTotal#prixPhotos*nbPhotos#pasliste" algoitem="prixTotal PREND_LA_VALEUR prixPhotos*nbPhotos"/>
                            <item code="4#Le nombre de copie est de : #0" algoitem="AFFICHER &quot;Le nombre de copie est de : &quot;"/>
                            <item code="3#nbPhotos#1#pasliste" algoitem="AFFICHER nbPhotos"/>
                            <item code="4#Le prix total est de : #0" algoitem="AFFICHER &quot;Le prix total est de : &quot;"/>
                            <item code="3#prixTotal#0#pasliste" algoitem="AFFICHER prixTotal"/>
                            <item code="4# €#0" algoitem="AFFICHER &quot; €&quot;"/>
                            <item code="8#finsi" algoitem="FIN_SI"/>
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
