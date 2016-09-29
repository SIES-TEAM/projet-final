# projet-final
Projet de fin d'année, il s'agit d'un outil de gestion des ressources (salles et ordis) de Simpoln.

Les membres de ce team peuvent forker(Fork) et puller (git pull) sur le projet mais ne peuvent pas pusher (git push)

Pour pusher on doit passer par les Pull request ou (Merge request).
# Pull request #

# Qu'est ce que c'est ?

Une Pull request est une soumission de code. Le développeur soumet son code à la relecture pour validation (d'un autre développeur) et ainsi assuré la qualité du projet

# Pourquoi faire ?

Faire des "Pull request" (PR) permet de rendre plus facile la revue de code. La revue de code est une bonne pratique dans le développement pour les raisons suivants.

    S'inspirer du code bien fait
    Détecter des défauts dans le code avant que ce soit critique
    Valoriser le travail de l'équipe
    Progression plus rapide des dev plus junior.
    Echanger
    

# Comment faire ?

  Etapes à suivre:
  
    
    1- Forker le projet dans son propre compte Github.

    2- Cloner votre fork (voilà mon example):

            git clone git@github.com:SalahO/projet-final.git
   
       Le dépôt (repo) représente mon "Origin"
       Vous devez remplacer SalahO par la recinde de vos repos
   
    3-  Ajouter le dépôt principal "upstream"
        
            git remote add upstream git@github.com:SIES-TEAM/projet-final.git
            
       Pour pusher à la fin de chaque fonctionnalité c'est sur "origin" qu'il faut faire en faisant 
            
            git push origin <nom de la branche>
            
    4- Créer une PR (Pull request)
    
       Cliquer sur le bouton [New pull request]
       Choisir les branches, branch source c'est votre branch "origin" sur laquel le code est poussé (push).
        et la branch target c'est la branch "upstream" vers laquelle on veut pousser le code.
    
     
        
       
        



  
