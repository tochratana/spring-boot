#!/bin/bash

# Ask for commit message
echo "Enter your commit message:"
read commitMessage

# Git commands
git add .
git commit -m "$commitMessage"
git push origin master

echo "Code pushed to GitHub successfully!"