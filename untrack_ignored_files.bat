@rem Remove the files from the index (not the actual files in the working copy)
git rm -r --cached .

@rem Add these removals to the Staging Area...
git add .

@rem ...and commit them!
git commit -m "Clean up ignored files"