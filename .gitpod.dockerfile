FROM gitpod/workspace-full

USER root

RUN yes | curl https://cli-assets.heroku.com/install-ubuntu.sh | sh
