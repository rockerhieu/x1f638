#!/bin/sh

if [ -n "$CIRCLE_COMPARE_URL" ]; then
  git log --reverse `echo $CIRCLE_COMPARE_URL | sed 's/^\([^.]*\)\.\.\.\([^.]*\)$/\1/' | sed 's/^.*\/\([^/]*\)$/\1/'` --pretty=format:"%s" | sed '/^Merge .*$/d'
fi
if [ -n "$SHIPPABLE_COMMIT_RANGE" ]; then
  git log --reverse `echo $SHIPPABLE_COMMIT_RANGE | sed 's/^\([^.]*\)\.\.\.\([^.]*\)$/\1/'`..`echo $SHIPPABLE_COMMIT_RANGE | sed 's/^\([^.]*\)\.\.\.\([^.]*\)$/\2/'` --pretty=format:"%s" | sed '/^Merge .*$/d'
fi