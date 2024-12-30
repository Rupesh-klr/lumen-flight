#!/bin/bash

if [ "$SOME_ENV" = "SOME_VALUE" ] ; then
  exec run_this_command -p 8090
else
  exec run_that_other_command
fi
