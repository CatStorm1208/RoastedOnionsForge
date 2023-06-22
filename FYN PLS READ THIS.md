This file purely exists so that Fyndrix knows how to use git on this project properly.

<h1> Before doing anything </h1>
1. Create your branch on GitHub <br>
2. In the terminal type: git pull origin branchname <br>
3. You can now edit stuff

<h1> Committing & Pushing </h1>
1. Click on the green checkmark on the top right <br>
2. Type your commit description <br>
3. Click on commit and push. It might give you warnings, click on the x warnings
in the same box were you typed the commit description and review the warnings.
The warnings "Cant resolve symbol 'forge/minecraft/farmersdelight/byg'" can be ignored.
Then do Commit and Push anyway <br>
4. Before you press on Push first go to the top left of the push menu where it should
say "origin : master" click on master and change it to your branchname.

<h1> Pull requests </h1>
After you have pushed some commits to your branch and think that you are done, 
go to GitHub and open a pull request from your branch to the branch you wanna merge
into (usually master).

<h1> Important </h1>
Make sure to update the version number of mods.toml (line 16) and of
build.gradle (line 19). These versions must be identical. Versions with an underscore
must not be declared in those files. For example: Version of mod 1.2_01 -> version in files 1.2