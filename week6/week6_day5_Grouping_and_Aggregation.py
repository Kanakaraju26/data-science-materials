import pandas as pd

df = pd.read_csv("C:\\Users\\Home\\Documents\\data science\\week6\\data\\day3_engineer.csv")

ln = df.groupby("country")["show_id"].count().sort_values(ascending=False)
ln = df.groupby("age_group")["duration_mins"].mean()
ln = df.groupby("added_year")["show_id"].count()

ln = df.groupby("director").agg({
    "show_id": "count",
    "duration_mins": "mean"
}).sort_values("show_id", ascending=False)
ln = df.groupby("country").agg({
    "show_id":"count",
    "duration_mins":"mean"
}).sort_values(by="show_id",ascending=False)
ln = df.groupby("is_movie").agg(
    total_titles=("show_id", "count"),
    avg_duration=("duration_mins", "mean"),
    earliest_release=("release_year", "min")
)

ln = df.groupby(["country", "age_group"])["show_id"].count().sort_values(ascending=False).head(10)
ln = df.groupby(["release_decade", "is_movie"])["duration_mins"].mean().head(10)

ln = pd.pivot_table(df, values="show_id", index="added_year", columns="is_movie", aggfunc="count")
ln = pd.pivot_table(df, values="duration_mins", index="age_group", columns="is_movie", aggfunc="mean")

ln = [col for col in df.columns if col.startswith("rating_")]
ln = df[ln].sum().sort_values(ascending=False)
ln = df.groupby("is_movie")[ln].sum().T
print(ln)