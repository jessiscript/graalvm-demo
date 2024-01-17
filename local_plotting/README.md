# How to locally plot native image build data using the cloned git repository

## Persist build data
Make sure your build metric data are persisted in GitHub.
If not no plot for native image build data can be created.
To persist your build data by building native images with GitHub actions enable the `Read and write permissions` under `Workflow permissions` (link: https://github.com/user_account/repo_name/settings/actions).

## Install dependencies
Install python with Version `3.12`.

Install `pip`

Run `pip install -r local_plotting/requirements.txt`

## Get metric data
Check out the branches of interest.

Depending on your platform, either run:
* `git fetch origin refs/graalvm-metrics/*:refs/graalvm-metrics/*` or
* `git fetch origin 'refs/graalvm-metrics/*:refs/graalvm-metrics/*'`

on each branch to fetch all the metric references that contain the report data.


## Plot Data
To plot the data, make sure that you are in your cloned git repository and run:

`py local_plotting/main.py [repo_path] [branch] [n] [metrics_type]`

Parameters:  
`repo_path` = relative path to local git repository  
`branch` = name of the branch  
`n` = last n builds to be plotted  
`metrics_type` = Type of report metrics to be visualized. Either 'image_details', 'analysis_results', or 'resource_usage'  

The plot should show up in the browser and a copy of the .html is saved under `/local_plotting/output`

