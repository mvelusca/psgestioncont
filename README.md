ECM As A Service

Projet de plateforme de GED à la demande basée sur VueJS / Spring et les Conteneurs

2 modules
- Frontend 
- Spring Backend


Le module Frontend est le module qui va contenur le code de l'interface graphique en VueJS 

Le module Spring Back va comporter plusieurs composants :
- un contrôleur web qui va réceptionner les requêtes REST qui seront envoyées depuis l'interface graphique
- une partie batch qui va permettre d'appliquer les requêtes demandées depuis l'interface graphique sur les conteneurs (création de Conteneurs, démarrage d'un conteneur, etc.)

Cette partie batch, pour interagir avec le kubernetes qui va faire tourner les conteneurs, s'appuiera sur l'api client kubernetes

Le module Spring Backend permettra également de gérer les authentifiations et autorisations des utuilisateurs ainsi que l'administrations de ces mêmes utuilisateurs.
# psgestioncont
