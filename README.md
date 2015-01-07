# Robot Code 2015 [![Build Status](https://travis-ci.org/HarkerRobo/robocode15.png?branch=master)](https://travis-ci.org/HarkerRobo/robocode15)

Team 1072's code for the FRC 2015 competition

## Contributing

**1. Get the latest code from Github**

You'll need to understand a little bit about how git and gihub work before this step (if you need an introduction guide, Github has a good one you can learn from). In simple terms, log in to github, visit the robocode15 project page, and click the "fork" button to create your own copy of the repo. You will push your changes to this new repo under your own github account, and we will pull changes into the main repo from there. Now, we want to grab the latest from this newly created repository and pull it down to your local machine. Getting the latest code from your repo is simple, just clone it:

```
git clone https://github.com/harkerrobo/robocode15.git --recursive
cd robocode15
```
This will give you a directory called "robocode15" on your local machine with the latest checkout from your fork of the main robocode15 repo. Note: this is not a direct reference to the main robocode15 repo. When you make changes in your fork, you'll need to let us know about it so we can pull it over....but that's later in the process.

**2. Add a remote for the main robocode15 repo**

One thing you'll need to do to make things easier to integrate and keep up to date in your fork is to add the main robocode15 repo as a remote reference. This way you can fetch the latest code from the production version and integrate it. So, here's how to set that up:

```
git remote add upstream https://github.com/harkerrobo/robocode15.git
git remote
```
Then, when you need to pull the latest from the main robocode15 repo, you just fetch and merge the master branch:

```
git fetch upstream
git merge upstream/master
```
You can also use `git pull upstream master` if you want it all in one step.

**3. Making a branch for your changes**

When adding features or bug fixes, please create a separate branch for each changeset you want us to pull in, either with the issue number in the branch name or with an indication of what the feature is.

```
git branch   (lists your current branches)
git branch my_new_code   (makes a new branch called my_new_code)
git checkout my_new_code
```

**4. Push your code and make a pull request**

When you have finished making your changes, you'll need to push up your changes to your fork so we can grab them. With them all committed, push them:

```
git push origin my_new_code
```
This pushes everything in that branch up. Then you can go back to your forked robocode15 github page and issue a pull request from there. Tell us what you want us to merge and what it does/fixes, and one of us will pick it up.

That lets us know that there's something new from you that needs to be pulled in. We'll review it and get back to you about it if we have any questions. Otherwise, we'll integrate it and let you know when it's in!

*inspired from the `joind.in` repository contributing guidelines*
