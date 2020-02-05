# Information about this repository

This repository has been formed from the original android/wish-app-android repository at ControlThings Oy Ab using the following commands:

```sh
git clone -b v0.2.0-release foremost.controlthings.fi:/ct/mist/android/wish-app-android --depth 1
echo 1fc598b4486b7ac6604a5de7410177cce6814a59 >.git/info/grafts
git filter-branch -- --all
git remote remove origin
#Check that there are not other remotes
git prune
git gc --aggressive
```
